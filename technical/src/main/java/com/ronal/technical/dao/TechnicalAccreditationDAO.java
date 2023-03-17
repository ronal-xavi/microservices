package com.ronal.technical.dao;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "tb_technical_accreditation")
public class TechnicalAccreditationDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_technician", referencedColumnName = "id")
    private TechnicalDAO technicalDAO;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_accreditation", referencedColumnName = "id")
    private AccreditationDAO accreditationDAO;
}
