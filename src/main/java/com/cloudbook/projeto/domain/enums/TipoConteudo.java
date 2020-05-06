package com.cloudbook.projeto.domain.enums;



public enum TipoConteudo {
	
	AUDIO(1,"Áudio"),
	IMAGEM(2,"Imagem"),
	VIDEO(3,"Vídeo"),
	ANOTACAO(4,"Anotação");
	
	private int cod;
	private String desc;
	
	private TipoConteudo(int cod,String desc) {
		this.cod=cod;
		this.desc=desc;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public static TipoConteudo toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		
		for(TipoConteudo x: TipoConteudo.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido "+cod);
	}
}