package com.loginms.loginms.utilities;

public class Constantes {

    /**
     * Urls
     */
    public final class Urls {
        /**
         * Coonstante PATH_USUARIO
         */
        public final static String PATH_USUARIO = "usuario";
        /**
         * Coonstante PATH_USUARIO_USER
         */
        public final static String PATH_USUARIO_USER = "{usuario}";
        /**
         * Coonstante PATH_DESCRIP
         */
        public final static String PATH_DESCRIP = "descripcion";
        /**
         * Coonstante PATH_DESCRIP_ID
         */
        public final static String PATH_DESCRIP_ID = "{id}";
        /**
         * Coonstante PATH_CONTABILIDAD
         */
        public final static String PATH_CONTABILIDAD = "contabilidad";
        /**
         * Coonstante PATH_CONTABILIDAD_ID
         */
        public final static String PATH_CONTABILIDAD_ID = "{idContabilidad}";
        /**
         * Coonstante PATH_CATEGORIA
         */
        public final static String PATH_CATEGORIA = "categoria";
        /**
         * Coonstante PATH_CATEGORIA_ID
         */
        public final static String PATH_CATEGORIA_ID = "{idCategoria}";
        /**
         * Coonstante PATH_OPER_BASICAS
         */
        public final static String PATH_OPER_BASICAS = "operaciones/basicas";
        /**
         * Coonstante PATH_OPER_BASICAS_USUARIO_GAST
         */
        public final static String PATH_OPER_BASICAS_USUARIO_GAST = "gasto/total/{usuario}";
        /**
         * Coonstante PATH_OPER_BASICAS_USUARIO_INGRE
         */
        public final static String PATH_OPER_BASICAS_USUARIO_INGRE = "ingreso/total/{usuario}";

        private Urls() {
        }
    }

}
