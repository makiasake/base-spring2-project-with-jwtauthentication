package com.makiasake.basespring2withjwtauthentication.domain.enums;

import java.util.Objects;

public enum Profile {
	ADMIN(1, "ROLE_ADMIN"), USER(2, "ROLE_USER"),;

	private int code;
	private String description;

	private Profile(int cod, String descricao) {
		this.code = cod;
		this.description = descricao;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public static Profile toEnum(Integer cod) {

		if (Objects.isNull(cod)) {
			return null;
		}

		for (Profile x : Profile.values()) {
			if (cod.equals(x.getCode())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
