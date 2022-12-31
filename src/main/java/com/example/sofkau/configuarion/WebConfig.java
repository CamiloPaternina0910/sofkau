package com.example.sofkau.configuarion;

import com.example.sofkau.dtos.NaveDto;
import com.example.sofkau.enumeraciones.TiposNaves;
import com.example.sofkau.servicios.NaveServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements ApplicationRunner {

	@Autowired
	private NaveServicio naveServicio;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Creando las naves iniciales

		NaveDto nave = new NaveDto("Saturno", TiposNaves.LANZADERA, (float)1500,(float)12);
		naveServicio.guardar(nave);


		NaveDto nave2 = new NaveDto("Jupiter", TiposNaves.LANZADERA, (float) 1302, 10);
		naveServicio.guardar(nave2);


		NaveDto nave3 = new NaveDto("Luna", TiposNaves.LANZADERA, (float)1211,(float)11);
		naveServicio.guardar(nave3);


		NaveDto nave4 = new NaveDto("James webb", TiposNaves.NO_TRIPULADAS, (float) 1002, 10);
		naveServicio.guardar(nave4);


		NaveDto nave5 = new NaveDto("Curiosity", TiposNaves.NO_TRIPULADAS, (float)500,(float)1);
		naveServicio.guardar(nave5);


		NaveDto nave6 = new NaveDto("Leon", TiposNaves.NO_TRIPULADAS, (float) 102, 90);
		naveServicio.guardar(nave6);


		NaveDto nave7 = new NaveDto("Tierra", TiposNaves.TRIPULADAS, (float)1100,(float)12);
		naveServicio.guardar(nave7);


		NaveDto nave8 = new NaveDto("Marte", TiposNaves.TRIPULADAS, (float) 1311, 10);
		naveServicio.guardar(nave8);

		NaveDto nave9 = new NaveDto("Mercury", TiposNaves.TRIPULADAS, (float) 1111, 11);
		naveServicio.guardar(nave9);

	}

}
