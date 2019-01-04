import auth0 from 'auth0-js';
import history from '../../history';

export default class Auth {
    scopes;
    requestedScopes = 'openid profile read:messages write:messages';
    userProfile;
    accessToken;
    idToken;
    expiresAt;
    tokenRenewalTimeout;

    auth0 = new auth0.WebAuth({
        domain: 'mexicocity.eu.auth0.com',
        clientID: 'pqRxWaTon0yovXgcHi3H4o9JIM5fPsqj',
        redirectUri: 'http://localhost:3000/callback',
        responseType: 'token id_token',
        audience: 'https://mexicocity/api',
        scope: this.requestedScopes
    });


    constructor() {
        this.login = this.login.bind(this);
        this.logout = this.logout.bind(this);
        this.handleAuthentication = this.handleAuthentication.bind(this);
        this.isAuthenticated = this.isAuthenticated.bind(this);
        this.getAccessToken = this.getAccessToken.bind(this);
        this.getIdToken = this.getIdToken.bind(this);
        this.renewSession = this.renewSession.bind(this);
        this.getProfile = this.getProfile.bind(this);
        this.scheduleRenewal();
    }

    scheduleRenewal() {
        let expiresAt = this.expiresAt;
        const timeout = expiresAt - Date.now();
        if (timeout > 0) {
            this.tokenRenewalTimeout = setTimeout(() => {
                this.renewSession();
            }, timeout);
        }
    }

    getExpiryDate() {
        return JSON.stringify(new Date(this.expiresAt));
    }

    getProfile(cb) {
        this.auth0.client.userInfo(this.accessToken, (err, profile) => {
            if (profile) {
                this.userProfile = profile;
            }
            cb(err, profile);
        });
    }



    handleAuthentication() {
        this.auth0.parseHash((err, authResult) => {
            if (authResult && authResult.accessToken && authResult.idToken) {
                this.setSession(authResult);
            } else if (err) {
                history.replace('/myprofile?id=1');
                console.log(err);
                // alert(`Error: ${err.error}. Check the console for further details.`);
            }
        });
    }

    getAccessToken() {
        return this.accessToken;
    }

    getIdToken() {
        return this.idToken;
    }

    setSession(authResult) {
        // Set isLoggedIn flag in localStorage
        localStorage.setItem('isLoggedIn', 'true');

        // schedule a token renewal
        this.scheduleRenewal();

        // Set the time that the access token will expire at
        let expiresAt = (authResult.expiresIn * 30000) + new Date().getTime();
        this.accessToken = authResult.accessToken;
        this.idToken = authResult.idToken;
        this.expiresAt = expiresAt;

        // Set the users scopes
        this.scopes = authResult.scope || this.requestedScopes || '';

        // navigate to the home route
        history.replace('/myprofile?id=1');
    }

    renewSession() {
        this.auth0.checkSession({}, (err, authResult) => {
            if (authResult && authResult.accessToken && authResult.idToken) {
                this.setSession(authResult);
            } else if (err) {
                this.logout();
                console.log(err);
                // alert(`Could not get a new token (${err.error}: ${err.error_description}).`);
            }
        });
    }


    logout() {
        // Remove tokens and expiry time
        this.accessToken = null;
        this.idToken = null;
        this.expiresAt = 0;

        // Remove isLoggedIn flag from localStorage
        localStorage.removeItem('isLoggedIn');

        // Remove user profile
        this.userProfile = null;

        // Clear token renewal
        clearTimeout(this.tokenRenewalTimeout);

        // navigate to the home route
        history.replace('/');
    }

    userHasScopes(scopes) {
        const grantedScopes = this.scopes.split(' ');
        return scopes.every(scope => grantedScopes.includes(scope));
    }

    login() {
        this.auth0.authorize();
    }


    isAuthenticated() {
        // Check whether the current time is past the
        // access token's expiry time
        let expiresAt = this.expiresAt;
        return new Date().getTime() < expiresAt;
    }


}