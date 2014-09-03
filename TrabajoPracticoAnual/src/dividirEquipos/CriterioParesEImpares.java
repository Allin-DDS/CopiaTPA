package dividirEquipos;

import inscripcion.Inscripcion;

import java.util.Collection;
import java.util.PriorityQueue;

public class CriterioParesEImpares implements CriterioParaDividirEquipos {
	
	public void dividirEquipos(Collection<Inscripcion> equipo1, Collection<Inscripcion> equipo2, PriorityQueue<Inscripcion> primeros10Ordenados){
		for (int i=1;i<=5;i++){
			equipo1.add(primeros10Ordenados.poll());
			equipo2.add(primeros10Ordenados.poll());
		}
	}
}
