package com.allos.pomodoro.entity.enums;

public enum StatusTarefa {

    CONCLUIDA,//(1,"Concluido"),
    CANCELADA,//(2, "Cancelada"),
    PENDENTE,//(3, "Pendente"),
    EM_EXECUCAO//(4, "Em execucao ");

/*    private int cod;
    private String descricao;

    private StatusTarefa(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod(){
        return cod;
    }

    public String getDescricao(){
        return descricao;
    }

    public static StatusTarefa toEnum(Integer cod){
        if (cod == null){
            return null;
        }
        for (StatusTarefa x : StatusTarefa.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalido " + cod);
    }*/
}
