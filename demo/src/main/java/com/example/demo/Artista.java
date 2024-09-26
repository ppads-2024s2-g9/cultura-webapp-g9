package com.example.demo;

 class Artista {
    
    private String nome;
    private int anoNascimento;
    private String nomeArtistico;
    private String generoMusical;
    private String nacionalidade;

    public Artista() {
        super();
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getanoNascimento() {
        return anoNascimento;
    }

    public void setanoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getnomeArtistico() {
        return nomeArtistico;
    }

    public void setnomeArtistico(String nomeArtistico) {
        this.nomeArtistico = nomeArtistico;
    }

    public String getgeneroMusical() {
        return generoMusical;
    }

    public void setgeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}