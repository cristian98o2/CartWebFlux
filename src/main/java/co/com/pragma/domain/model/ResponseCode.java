package co.com.pragma.domain.model;

import lombok.Getter;

@Getter
public enum ResponseCode {
    LCC000(500, "Ocurrio un error inesperado, por favor intenta mas tarde."),
    LCC001(400, "Error en la validacion de campos"),
    LCC002(200, "Operacion exitosa."),
    LCC003(400, "Campos no validos."),
    LCC004(500, "Mal uso de la clase utilitaria."),
    LCC005(400, "Peticion mala, revise los parametros enviados."),
    LCC006(400, "Ocurrio un error al realizar la peticion HTTP."),
    LCC007(500, "Variable de entorno no encontrada."),
    LCC008(500, "Ocurrio un error realizando operaciones de persistencia."),
    LCC009(400, "El carrito solicitado no existe o no esta disponible."),
    LCC010(200, "La orden esta siendo procesada."),
    LCC011(400, "El carrito no cumple con el valor minimo para ser orden."),
    LCC012(400, "El tipo de inventario para los productos no es valido."),
    LCC013(400, "Error al procesar el cuerpo de la peticion. Por favor, revise los datos enviados."),
    LCC014(400, "No se cuenta en stock la cantidad de productos solicitados"),
    LCC015(200,"Algunos Productos fueron retirados del carrito porque no existen en el sistema.");

    private final int status;
    private final String htmlMessage;
    ResponseCode(int status, String htmlMessage) {
        this.status = status;
        this.htmlMessage = htmlMessage;
    }
}
