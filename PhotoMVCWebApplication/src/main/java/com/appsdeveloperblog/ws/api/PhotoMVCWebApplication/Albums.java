package com.appsdeveloperblog.ws.api.PhotoMVCWebApplication;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Albums {
	
	private final String id;
	private final String title;
	private final String url;
	private final LocalDate cadastro;
	
	public static class Builder{
		private  String id;
		private  String title;
		private  String url;
		private  LocalDate cadastro = LocalDate.now();
		
		public Builder(String id, String title, String url) {
			this.id = id;
			this.title = title;
			this.url = url;
		}
		
		public Builder cadastro(LocalDate cadastro) {
			this.cadastro = cadastro;
			return this;
		}
		
		public Albums build() {
			return new Albums(this);
		}
	}
	
	private Albums (Builder build) {
		this.id = build.id;
		this.title = build.title;
		this.url = build.url;
		this.cadastro = build.cadastro;
	}

}
