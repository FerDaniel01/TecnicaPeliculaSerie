package app.tecnica.peliculasseries.utilidades;

public class Utilidades {
    public static final String TABLA_CONTENIDO= "contenido";
    public static final String CAMPO_TITULO= "titulo";
    public static final String CAMPO_ANIO= "anio";
    public static final String CAMPO_CLASI= "clase";


    public static final String CREAR_TABLA_CONTENIDO="CREATE TABLE "
            +TABLA_CONTENIDO+"("+CAMPO_TITULO+
            " TEXT, "+CAMPO_ANIO+" TEXT, "+CAMPO_CLASI+" TEXT)";
}
