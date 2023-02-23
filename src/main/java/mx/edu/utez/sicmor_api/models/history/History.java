package mx.edu.utez.sicmor_api.models.history;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="history")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int airHumididty;

    @Column(nullable = false)
    private int airTemperature;

    @Column(nullable = false)
    private int soilHumididty;

    @Column(nullable = false)
    private int soilTemperature;

    @Column(nullable = false)
    private int luminosity;





}
