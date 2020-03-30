package dev.domain;

import javax.persistence.*;

@Entity
public class RoleCollegue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "collegue_id")
    private Collegue collegue;

    @Enumerated(EnumType.STRING)
    private RoleAppli role;

    public RoleCollegue() {
    }

    public RoleCollegue(Collegue collegue, RoleAppli role) {
        this.collegue = collegue;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleAppli getRole() {
        return role;
    }

    public void setRole(RoleAppli role) {
        this.role = role;
    }

    public Collegue getCollegue() {
        return collegue;
    }

    public void setCollegue(Collegue collegue) {
        this.collegue = collegue;
    }
}
