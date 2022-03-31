package com.appsdeveloperblog.keycloak;

import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialInputValidator;
import org.keycloak.credential.UserCredentialStore;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.credential.PasswordCredentialModel;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.adapter.AbstractUserAdapter;
import org.keycloak.storage.user.UserLookupProvider;

public class RemoteUserStorageProvider implements UserStorageProvider, UserLookupProvider, CredentialInputValidator{
	
	private KeycloakSession session;
	private ComponentModel model;
	private UsersApiService userService;
	
	public RemoteUserStorageProvider(KeycloakSession session, ComponentModel model, UsersApiService userService) {
		this.session = session;
		this.model = model;	
		this.userService = userService;
	}

	@Override
	public void close() {}

	@Override
	public UserModel getUserById(String id, RealmModel realm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getUserByUsername(String username, RealmModel realm) {
		UserModel returnValue = null;
		
		User user = userService.getUserDetails(username);
		if(user !=null) {
			returnValue = createUserModel(username, realm);
		}
		
		return returnValue;
	}
	

	private UserModel createUserModel(String username, RealmModel realm) {
		return new AbstractUserAdapter(session, realm, model) {
			@Override
			public String getUsername() {
				return username;
			}
		};
	}
	

	@Override
	public UserModel getUserByEmail(String email, RealmModel realm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supportsCredentialType(String credentialType) {
		return PasswordCredentialModel.TYPE.equals(credentialType);
	}

	@Override
	public boolean isConfiguredFor(RealmModel realm, UserModel user, String credentialType) {
		if(!supportsCredentialType(credentialType)) {
			return false;
		}
		return !getCredentialStore().getStoredCredentialsByType(realm, user, credentialType).isEmpty();
	}
	
	private UserCredentialStore getCredentialStore() {
		return session.userCredentialManager();
	}

	@Override
	public boolean isValid(RealmModel realm, UserModel user, CredentialInput credentialInput) {
		VerifyPasswordResponse verify = userService.verifyUserPassword(user.getUsername(), 
				credentialInput.getChallengeResponse());
		
		if(verify == null) return false;
		return verify.getResult();
	}

}
