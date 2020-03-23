package dev.domain.occupation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dev.domain.CoursPlanifie;
import dev.domain.Salle;
import dev.domain.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service pour le calcul des occupations de salle d'une session
 * 
 * @author DIGINAMIC
 *
 */
@Service
public class OccupationSalleServiceImpl implements OccupationSalleService {

	/** occupationSalleService : OccupationSalleService */
	@Autowired
	private OccupationSalleService occupationSalleService;

	@Override
	public List<OccupationSalle> getOccupations(Session session) {

		int position = 0;
		List<OccupationSalle> occupations = new ArrayList<>();

		List<CoursPlanifie> listeCours = session.getCours();
		Collections.sort(listeCours);

		for (CoursPlanifie cours : listeCours) {
			if (occupations.isEmpty()) {
				addOccupation(occupations, session, cours, position++);
			}
			else {
				OccupationSalle occupation = occupations.get(occupations.size() - 1);

				if (occupationSalleService.changementOccupation(cours.getSalle(), occupation.getSalle())) {
					addOccupation(occupations, session, cours, position++);
				}
				else {
					occupation.setDateFin(cours.getDateFin());
					occupation.getCours().add(cours.getId());
				}
			}
		}
		return occupations;
	}

	/**
	 * Ajoute une nouvelle occupation à la liste des occupations de salle dès lors qu'on change de
	 * salle et/ou de modalité pédagogique.
	 * 
	 * @param occupations liste des occupations
	 * @param session session
	 * @param cours cours
	 * @param position numérotation de l'occupation dans l'ordre chronologique
	 */
	private void addOccupation(List<OccupationSalle> occupations, Session session, CoursPlanifie cours, int position) {
		OccupationSalle occupation = null;
		if (cours.getModalitePedagogique().isBesoinSalle()) {
			Salle salleCours = cours.getSalle();
			if (salleCours == null) {
				salleCours = session.getSalle();
			}
			occupation = new OccupationSalle(cours.getDateDebut(), cours.getDateFin(), salleCours);
			occupations.add(occupation);
		}
		else {
			occupation = new OccupationSalle(cours.getDateDebut(), cours.getDateFin());
			occupations.add(new OccupationSalle(cours.getDateDebut(), cours.getDateFin()));
		}
		occupation.setPosition(position);
		occupation.getCours().add(cours.getId());
	}

	@Override
	public boolean changementOccupation(Salle salle, Salle salle2) {

		return (salle != null && salle2 == null) || (salle == null && salle2 != null)
				|| (salle != null && salle2 != null && !salle.getId().equals(salle2.getId()));
	}

}
