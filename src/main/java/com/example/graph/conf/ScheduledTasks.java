package com.example.graph.conf;

import com.example.graph.entity.Numero;
import com.example.graph.repository.NumeroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

//TODO decimos que esta clase es un componente para que lo cargue Spring boot
//Por que para la ejecución del @Scheduled se debe cargar en un componente.

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final Integer MIN = 0;

    private static final Integer MAX = 100;

    private NumeroRepository numeroRepository;

    //TODO inyectamos el repository
    @Autowired
    public ScheduledTasks (final NumeroRepository numeroRepository) {
        this.numeroRepository = numeroRepository;
    }

    //TODO Ejecutar cada 5 segundos (5000 milisegundos)
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        //TODO Generamos el número aleatorio.
        int randomNum = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);

        Numero numero = new Numero();
        numero.setNumero(randomNum);
        numero.setFecha(new Date());

        //TODO enviamos al log el número recien generado
        log.info("The number is now {}", numero);

        numeroRepository.save(numero);
    }

}
