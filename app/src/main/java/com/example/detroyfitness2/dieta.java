package com.example.detroyfitness2;

 class dieta{

    private String desayuno;
    private String almuerzo;
    private String comida;
    private String merienda;
    private String cena;
    private String dia;

     public dieta() {}

     public dieta(String desayuno, String almuerzo, String comida, String merienda, String cena, String dia) {
         this.desayuno = desayuno;
         this.almuerzo = almuerzo;
         this.comida = comida;
         this.merienda = merienda;
         this.cena = cena;
         this.dia = dia;
     }
     public String getDesayuno() {
         return desayuno;
     }
     public String getAlmuerzo() {
         return almuerzo;
     }
     public String getComida() {
         return comida;
     }
     public String getMerienda() {
         return merienda;
     }
     public String getCena() {
         return cena;
     }
     public String getDia() {
         return dia;
     }

}
