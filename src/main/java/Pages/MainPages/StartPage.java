package Pages.MainPages;

import Images.IMG;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;

public class StartPage {
    private final JButton loginButton, registerButton, quitButton;
    private final JLabel label;
    private static final int WIDTH_DIMENSION_ABSOLUTE = 200;
    private static final int HEIGHT_DIMENSION_ABSOLUTE = 50;
    private static final int Y_POSITION_ABSOLUTE = 426;
    private static final int X_POSITION_ABSOLUTE = 473;
    public static MongoCollection<Document> collection;
    private final MongoClient mongoClient;

    public StartPage() {
        mongoClient = MongoClients.create("mongodb+srv://admin:admin@atmdb.w56guwr.mongodb.net/test");
        MongoDatabase mongoDatabase = mongoClient.getDatabase("ATM");
        collection = mongoDatabase.getCollection("Users");
        label = new JLabel();
        label.setIcon(IMG.defaultBackground);
        label.add(loginButton = createLoginButton());
        label.add(registerButton = createRegisterButton());
        label.add(quitButton = createQuitButton());
        label.setVisible(true);
    }

    public JLabel getLabel() {
        refresh();
        return label;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    protected JButton createLoginButton() {
        JButton loginButton = new JButton(IMG.loginButton);
        loginButton.setContentAreaFilled(false);
        loginButton.setBounds(X_POSITION_ABSOLUTE, Y_POSITION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        loginButton.setBorder(null);
        return loginButton;
    }

    protected JButton createRegisterButton() {
        JButton registerButton = new JButton(IMG.registerButton);
        registerButton.setContentAreaFilled(false);
        registerButton.setBounds(X_POSITION_ABSOLUTE + 220, Y_POSITION_ABSOLUTE, WIDTH_DIMENSION_ABSOLUTE, HEIGHT_DIMENSION_ABSOLUTE);
        registerButton.setBorder(null);
        return registerButton;
    }

    protected JButton createQuitButton() {
        JButton quitButton = new JButton(IMG.quitButton);
        quitButton.setContentAreaFilled(false);
        quitButton.setBounds(Y_POSITION_ABSOLUTE - 421, Y_POSITION_ABSOLUTE + 405, WIDTH_DIMENSION_ABSOLUTE - 130, HEIGHT_DIMENSION_ABSOLUTE + 20);
        quitButton.addActionListener(a -> {
            mongoClient.close();
            IMG.s3Client.shutdown();
            System.exit(0);
        });
        quitButton.setBorder(null);
        return quitButton;
    }

    private void refresh() {
        label.setVisible(false);
        label.setVisible(true);
        loginButton.setVisible(false);
        loginButton.setVisible(true);
        registerButton.setVisible(false);
        registerButton.setVisible(true);
        quitButton.setVisible(false);
        quitButton.setVisible(true);
    }

    public void hide() {
        loginButton.setVisible(false);
        registerButton.setVisible(false);
        quitButton.setVisible(false);
        label.setVisible(false);
    }

    public void show() {
        loginButton.setVisible(true);
        registerButton.setVisible(true);
        quitButton.setVisible(true);
        label.setVisible(true);
    }


}
