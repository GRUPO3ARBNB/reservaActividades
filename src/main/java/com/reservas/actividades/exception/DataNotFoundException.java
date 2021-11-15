package com.reservas.actividades.exception;

import com.reservas.actividades.util.IMensajes;

public class DataNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6484765197597220910L;

    public DataNotFoundException() {
        super(IMensajes.DATA_NOT_FOUND);
    }

}
