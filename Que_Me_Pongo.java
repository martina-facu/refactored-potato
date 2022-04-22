class Prenda{
    Categoria categoria;
    String material;
    String tipo;
    Interger colorPrimario;
    Interger colorSecundario;

    Prenda(Categoria categoriaP,String tipoP, String materialP, Interger color1, Interger color2){
        if(this.validarDatos(categoriaP,tipoP,materialP,color1)){
            this.material = materialP;
            this.colorPrimario = color1;
            if(categoriaP.validarTipo(tipoP)){
                this.categoria = categoriaP;
                this.tipo = tipoP;
            }else{
                throw new Exception("El tipo de prenda y la categoria ingresada no coinciden para esta prenda");
            }

        }else{
            throw new Exception("Los parametros de la prenda no pueden ser nulos");
        }
        
        if(color2 != null){
            this.colorSecundario = color2;
        }       
    }

    Bool validarDatos(Categoria categoriaP,String tipoP, String materialP, Interger color1){
        return (categoriaP != null & tipoP != null & materialP != null & color1 != null);
    }
}

class Armario{
    List<Prenda> prendas = new ArrayList<Prenda>();

    void CargarPrenda(Prenda prenda){
        prendas.add(prenda);
    }
}

class Categoria{
    Bool validarTipo(String tipo){
        //no se me ocurrio que hacer aca podria ser un map con las combinaciones pero me parecio 
        //muy rebuscado y poco implementable
        return true;
    }
}
