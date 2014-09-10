package dividirEquipos;

import inscripcion.Inscripcion;

import java.util.Collection;
import java.util.PriorityQueue;

import org.uqbar.commons.model.IModel;

public interface CriterioParaDividirEquipos {

	public void dividirEquipos(Collection<Inscripcion> equipo1, Collection<Inscripcion> equipo2,
			PriorityQueue<Inscripcion> primeros10Ordenados);
	public String getNombre();
}
