package com.example.detroyfitness2;
 class Alimentos {

        private String nombre;
        private String carbohidratos;
        private String grasas;
        private String kcal;
        private String proteina;

        public Alimentos() {}

        public Alimentos(String nombre, String carbohidratos, String grasas, String kcal, String proteina) {
            this.nombre = nombre;
            this.carbohidratos = carbohidratos;
            this.grasas = grasas;
            this.kcal = kcal;
            this.proteina = proteina;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCarbohidratos() {
            return carbohidratos;
        }

        public void setCarbohidratos(String carbohidratos) {
            this.carbohidratos = carbohidratos;
        }

        public String getGrasas() {
            return grasas;
        }

        public void setGrasas(String grasas) {
            this.grasas = grasas;
        }

        public String getKcal() {
            return kcal;
        }

        public void setKcal(String kcal) {
            this.kcal = kcal;
        }

        public String getProteina() {
            return proteina;
        }

        public void setProteina(String proteina) {
            this.proteina = proteina;
        }


}
