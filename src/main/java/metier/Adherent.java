package metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the adherent database table.
 * 
 */
@Entity
@NamedQuery(name="Adherent.findAll", query="SELECT a FROM Adherent a")
public class Adherent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_adherent")
	private int idAdherent;

	@Column(name="nom_adherent")
	private String nomAdherent;

	@Column(name="prenom_adherent")
	private String prenomAdherent;

	@Column(name="ville_adherent")
	private String villeAdherent;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="adherent")
	private List<Booking> reservations;

	public Adherent() {
	}

	public int getId() {
		return this.idAdherent;
	}

	public void setId(int idAdherent) {
		this.idAdherent = idAdherent;
	}

	public String getLastname() {
		return this.nomAdherent;
	}

	public void setLastname(String nomAdherent) {
		this.nomAdherent = nomAdherent;
	}

	public String getFirstname() {
		return this.prenomAdherent;
	}

	public void setFirstname(String prenomAdherent) {
		this.prenomAdherent = prenomAdherent;
	}

	public String getCity() {
		return this.villeAdherent;
	}

	public void setCity(String villeAdherent) {
		this.villeAdherent = villeAdherent;
	}

	public List<Booking> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Booking> reservations) {
		this.reservations = reservations;
	}

	public Booking addReservation(Booking reservation) {
		getReservations().add(reservation);
		reservation.setAdherent(this);

		return reservation;
	}

	public Booking removeReservation(Booking reservation) {
		getReservations().remove(reservation);
		reservation.setAdherent(null);

		return reservation;
	}

}