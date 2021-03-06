package com.example.newprojectoption.service;

import com.example.newprojectoption.bean.*;
import com.example.newprojectoption.dao.AbsenceDao;
import com.example.newprojectoption.dao.EtatValidationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AbsenceService {
    @Autowired
    private AbsenceDao absenceDao;
    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private SeanceService seanceService;

    public int save(List<Absence> absences){
        for(Absence absence:absences){
            if(findByEtudiantCneAndSeanceLibelle(absence.getEtudiant().getCne(),absence.getSeance().getLibelle())!=null){
                return -1;
            }
            Absence absence1=new Absence();
            Etudiant etudiant =etudiantService.findByCne(absence.getEtudiant().getCne());
            Seance seance =seanceService.findByLibelle(absence.getSeance().getLibelle());
            if(etudiant==null || seance==null)
                return -2;
            absence1.setEtudiant(etudiant);
            absence1.setSeance(seance);
            absenceDao.save(absence1);
        }
        return 1;
    }

    public Absence findByEtudiantCneAndSeanceLibelle(String cne, String libelle) {
        return absenceDao.findByEtudiantCneAndSeanceLibelle(cne, libelle);
    }

    /*public List<Absence> findBySeanceDateSeance(Date date) {
        return absenceDao.findBySeanceDateSeance(date);
    }*/

    public List<Absence> findByEtatAbsenceTrueAndSeanceDate(String date) {
        return absenceDao.findByEtatAbsenceTrueAndSeanceDateSeance(date);
    }

    public void update(List<Absence> absences){
        for(Absence absence:absences){
            Absence abs=absenceDao.findByEtudiantCneAndSeanceLibelle(absence.getEtudiant().getCne(),absence.getSeance().getLibelle());
            abs.setEtatJustification(absence.getEtatJustification());
            absenceDao.save(absence);
        }
    }
}
