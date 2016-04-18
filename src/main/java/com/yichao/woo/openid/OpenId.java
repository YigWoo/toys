package com.yichao.woo.openid;

import org.openid4java.consumer.ConsumerException;
import org.openid4java.consumer.ConsumerManager;
import org.openid4java.discovery.DiscoveryException;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.MessageException;

import java.util.List;

/**
 * Created by Yichao-Woo.
 */
public class OpenId {
    private static final String STEAM_OPENID = "http://steamcommunity.com/openid";
    public static final String return_url = "http://localhost:8080/steam/home";

    public static void main(String[] args) {
        ConsumerManager consumerManager = new ConsumerManager();
        consumerManager.setMaxAssocAttempts(0);
        DiscoveryInformation discoveryInformation;
        try {
            List discoveries = consumerManager.discover(STEAM_OPENID);
            discoveryInformation = consumerManager.associate(discoveries);

            AuthRequest authenticate = consumerManager.authenticate(discoveryInformation, return_url);
            String destinationUrl = authenticate.getDestinationUrl(true);
            System.out.println(destinationUrl);
        } catch (DiscoveryException | MessageException | ConsumerException e) {
            e.printStackTrace();
        }


    }
}
