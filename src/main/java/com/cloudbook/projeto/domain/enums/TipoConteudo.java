package com.cloudbook.projeto.domain.enums;



public enum TipoConteudo {
	
	ANOTACAO(1,"Anotação"),
	IMAGEM(2,"Imagem");
	
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