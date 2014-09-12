package dividirEquipos;

import inscripcion.Inscripcion;

import java.util.Collection;
import java.util.PriorityQueue;

import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;

@Transactional


public interface CriterioParaDividirEquipos {

	public void dividirEquipos(Collection<Inscripcion> equipo1, Collection<Inscripcion> equipo2,
			PriorityQueue<Inscripcion> primeros10Ordenados);
	public String getNombre();
}
