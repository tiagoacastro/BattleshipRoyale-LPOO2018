package com.mygdx.game.utility;

import com.badlogic.gdx.Gdx;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.scope.ScopeBuilder;

/**
 * Class for login into facebook
 */
public class Facebook {
    private FacebookClient facebookClient;
    private ScopeBuilder scopeBuilder;
    /**
     * Facebook class constructor initializing scopeBuilder and the facebook client
     */
    public Facebook() {
        scopeBuilder = new ScopeBuilder();
        facebookClient = new DefaultFacebookClient(Version.VERSION_2_9);
    }
    /**
     * Logs the user into facebook
     */
    public void login() {
        String appId = "404127593399770";
        String redirectUrl = "https://www.facebook.com/connect/login_success.html";
        String loginDialogUrl = facebookClient.getLoginDialogUrl(appId, redirectUrl, scopeBuilder);
        Gdx.net.openURI(loginDialogUrl);
    }
}
