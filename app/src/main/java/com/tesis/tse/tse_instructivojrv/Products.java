package com.tesis.tse.tse_instructivojrv;

/**
 * Datos de prueba para las pestañas
 */
public class Products {

    private static Product[] telefonos = {
            new Product(
                    "Abrir centros de votación",
                    "Ingreso de las personas propietarias y suplentes de la JRV debidamente identificados con su DUI y credencial del TSE.",
                    "(ver mas)",
                    3.1f,
                    R.drawable.logo_tse),
            new Product(
                    "Integrar la JRV",
                    "Integrar la JRV con un mínimo de 3 integrantes (Presidencia, Secretaría y 1er Vocal)",
                    "(ver mas)",
                    4.0f,
                    R.drawable.logo_tse)

    };

    private static Product[] tablets = {
            new Product(
                    "Votación",
                    "Votarán los integrantes de la JRV y vigilantes, tanto propietarios como suplentes.",
                    "(ver mas)",
                    5.0f,
                    R.drawable.logo_tse),
            new Product(
                    "Inicio de votación para la ciudadanía",
                    "La presidenta anunciará en voz alta que dará comienzo la votación para la ciudadanía",
                    "(ver mas)",
                    4.0f,
                    R.drawable.logo_tse)
    };

    private static Product[] portatiles = {
            new Product(
                    "Cierre de la votación",
                    "Debe ser anunciado por la presidenta y solicitar a una persona con función electoral" +
                            " y que esté acreditada ante la JRV que se coloque al final de la fila para asegurar que voten " +
                            "únicamente las personas que se encontraban en ella al momento del cierre.",
                    "(ver mas)",
                    5.0f,
                    R.drawable.logo_tse),
            new Product(
                    "Escrutinio de JRV",
                    "Pasos previos al escrutinio",
                    "(ver mas)",
                    4.0f,
                    R.drawable.logo_tse)
    };

    public static Product[] getTelefonos() {
        return telefonos;
    }

    public static Product[] getTablets() {
        return tablets;
    }

    public static Product[] getPortatiles() {
        return portatiles;
    }
}
