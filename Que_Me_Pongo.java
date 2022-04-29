class Armario{
    List<Prenda> prendas = new ArrayList<Prenda>();
    Borrador ultimoborrador;

    void CargarPrenda(Prenda prenda){
        prendas.add(prenda);
    }

    void crearBorrador(){
        this.ultimoBorrador = new Borrador(this);
    }

}
class Prenda{
    Categoria categoria;
    MateriaPrima material;
    Tipo tipo;
    Color colorPrimario;
    Color colorSecundario;

    Prenda(Tipo tipoP, MateriaPrima materialP, Color color1, Color color2){
        if(this.validarDatos(tipoP,materialP,color1)){
            this.material = materialP;
            this.colorPrimario = color1;
            this.tipo = tipoP;
            this.categoria = tipoP.getCategoria();
           
        }else{
            throw new RuntimeException("Los parametros de la prenda no pueden ser nulos");
        }
        
        if(color2 != null){
            this.colorSecundario = color2;
        }       
    }

    Bool validarDatos(Categoria categoriaP,String tipoP, String materialP, Interger color1){
        return (categoriaP != null & tipoP != null & materialP != null & color1 != null);
    }
}

class Borrador{
    Tipo tipo;
    Material material;
    Armario armario;

    Borrador(Armario armario){
        this.armario = armario;
    }

    void agragarTipo(Tipo tipo){
        this.tipo = tipo;
    }

    void agregarMaterial(MateriaPrima materia, Color color1, Color color2, Trama trama){
        this.material = new Material(materia, color1, color2, trama);
        //verificar que el material concuerde con el tipo no se me ocurrio bien como hacerlo organizado
    }

    void guardarBorradorFinalizado(){
        armario.agregarPrenda(new Prenda(tipo, material.materiaPrima, material.colorPrimario, material.colorSecundario));
    }
}

class Material{
    Trama trama = Trama.LISA;
    MateriaPrima materiaPrima;
    Color colorPrimario;
    Color colorSecundario;

    Material(MateriaPrima materia,Color color1, Color color2, Trama trama){
        this.material = materia;
        this.colorPrimario = color1;
        if(trama != null){
            this.trama = trama;
        }
        if(color2 != null){
            this.colorSecundario = color2;
        }  
    }
}

enum MateriaPrima{
    TELA, METAL, PLASTICO, LONA, CUERO;
}
enum Trama{
    LISA, RAYADA, LUNARES, CUADROS, ESTAMPADO;
}
class Color{
    Int red, green, blue;
  }

public enum Tipo {
    //public abstract Categoria getCategoria();

    REMERA {
        @Override
        public Categoria getCategoria() { return Categoria.PARTE_SUPERIOR; }

        public boolean materialValido(MateriaPrima material){
            return material == MateriaPrima.CUERO;
        }
    }, 
    PANTALON {
        @Override
        public Categoria getCategoria() { return Categoria.PARTE_INFERIOR; }
    },
    ZAPATO {
        @Override
        public Categoria getCategoria() { return Categoria.CALZADO; }
    },
    ABRIGO {
        @Override
        public Categoria getCategoria() { return Categoria.PARTE_SUPERIOR; }
    },
    COLLAR{
        @Override
        public Categoria getCategoria() { return Categoria.ACCESORIOS; }
    };
}

public enum Categoria {
    PARTE_SUPERIOR, PARTE_INFERIOR, CAZADO, ACCESORIOS;
}

