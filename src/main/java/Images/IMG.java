package Images;

import Pages.MainPages.StartPage;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import io.github.cdimascio.dotenv.Dotenv;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class IMG {
    public static AmazonS3 s3Client;

    public static ImageIcon defaultBackground, darkBackground, loginButton, registerButton, quitButton, backButton, oKButton, cancelButton, logoutButton, darkModeButton,
            accountDetailsButton, balanceButton, changePinButton, depositButton, donationButton, transactionsButton, transferButton, withdrawButton, deleteButton, cardBackground,
            donateButton, houseButton, redCrossButton, seasButton, transactionsBackground, treesButton, unicefButton, WFFButton;

    //TODO AmazonS3 database Images - Slow Load
    public IMG() throws IOException {
        Dotenv dotenv = Dotenv.load();
        String accessKey = dotenv.get("accessKey");
        String secretKey = dotenv.get("secretKey");
        assert accessKey != null;
        assert secretKey != null;
        s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey))).build();
        defaultBackground = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "background.jpg").getObjectContent()));
        darkBackground = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "DarkBackground.jpg").getObjectContent()));
        loginButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Login.png").getObjectContent()));
        registerButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Register.png").getObjectContent()));
        quitButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Quit.png").getObjectContent()));
        backButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Back.png").getObjectContent()));
        oKButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Ok.png").getObjectContent()));
        cancelButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Cancel.png").getObjectContent()));
        logoutButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "LogOut.png").getObjectContent()));
        darkModeButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Night-Day.png").getObjectContent()));
        accountDetailsButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "AccountDetails.png").getObjectContent()));
        balanceButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Balance.png").getObjectContent()));
        changePinButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "ChangePin.png").getObjectContent()));
        depositButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Deposit.png").getObjectContent()));
        donationButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Donation.png").getObjectContent()));
        transactionsButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Transactions.png").getObjectContent()));
        transferButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Transfer.png").getObjectContent()));
        withdrawButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Withdraw.png").getObjectContent()));
        deleteButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Delete.png").getObjectContent()));
        cardBackground = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "card.png").getObjectContent()));
        seasButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "seas.png").getObjectContent()));
        treesButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "trees.png").getObjectContent()));
        redCrossButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "red-cross.png").getObjectContent()));
        unicefButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "unicef.png").getObjectContent()));
        WFFButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "WFF.png").getObjectContent()));
        houseButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "house.png").getObjectContent()));
        donateButton = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "Donate.png").getObjectContent()));
        transactionsBackground = new ImageIcon(ImageIO.read(s3Client.getObject("atm-bank", "transaction.png").getObjectContent()));
    }


    //TODO Local Images - Fast Load
//    public IMG() throws IOException {
//        s3Client = AmazonS3ClientBuilder.standard().withRegion(Regions.EU_CENTRAL_1)
//                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIAUAYRRYQX6PY7LDXR", "n6thate+pxfEhp85bz1wZBb3Uol24YVnQ31dUUbm"))).build();
//        defaultBackground = new ImageIcon(ImageIO.read(new File("allPictures\\background.jpg")));
//        darkBackground = new ImageIcon(ImageIO.read(new File("allPictures\\darkBackground.jpg")));
//        loginButton = new ImageIcon(ImageIO.read(new File("allPictures\\login.png")));
//        registerButton = new ImageIcon(ImageIO.read(new File("allPictures\\register.png")));
//        quitButton = new ImageIcon(ImageIO.read(new File("allPictures\\quit.png")));
//        backButton = new ImageIcon(ImageIO.read(new File("allPictures\\back.png")));
//        oKButton = new ImageIcon(ImageIO.read(new File("allPictures\\ok.png")));
//        cancelButton = new ImageIcon(ImageIO.read(new File("allPictures\\cancel.png")));
//        logoutButton = new ImageIcon(ImageIO.read(new File("allPictures\\logOut.png")));
//        darkModeButton = new ImageIcon(ImageIO.read(new File("allPictures\\night-Day.png")));
//        accountDetailsButton = new ImageIcon(ImageIO.read(new File("allPictures\\accountDetails.png")));
//        balanceButton = new ImageIcon(ImageIO.read(new File("allPictures\\balance.png")));
//        changePinButton = new ImageIcon(ImageIO.read(new File("allPictures\\changePin.png")));
//        depositButton = new ImageIcon(ImageIO.read(new File("allPictures\\deposit.png")));
//        donationButton = new ImageIcon(ImageIO.read(new File("allPictures\\donation.png")));
//        transactionsButton = new ImageIcon(ImageIO.read(new File("allPictures\\transactions.png")));
//        transferButton = new ImageIcon(ImageIO.read(new File("allPictures\\transfer.png")));
//        withdrawButton = new ImageIcon(ImageIO.read(new File("allPictures\\withdraw.png")));
//        deleteButton = new ImageIcon(ImageIO.read(new File("allPictures\\delete.png")));
//        cardBackground = new ImageIcon(ImageIO.read(new File("allPictures\\card.png")));
//        seasButton = new ImageIcon(ImageIO.read(new File("allPictures\\seas.png")));
//        treesButton = new ImageIcon(ImageIO.read(new File("allPictures\\trees.png")));
//        redCrossButton = new ImageIcon(ImageIO.read(new File("allPictures\\red-cross.png")));
//        unicefButton = new ImageIcon(ImageIO.read(new File("allPictures\\unicef.png")));
//        WFFButton = new ImageIcon(ImageIO.read(new File("allPictures\\WFF.png")));
//        houseButton = new ImageIcon(ImageIO.read(new File("allPictures\\house.png")));
//        donateButton = new ImageIcon(ImageIO.read(new File("allPictures\\donate.png")));
//        transactionsBackground = new ImageIcon(ImageIO.read(new File("allPictures\\transaction.png")));
//    }
}
