package com.axsos.javaexam.services;

import com.axsos.javaexam.models.Team;
import com.axsos.javaexam.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepo;

    public TeamService(TeamRepository teamRepo) {
        this.teamRepo = teamRepo;
    }

    public List<Team> allTeams(){
        return teamRepo.findAll();
    }

    public Team findTripById(Long id) {
        Optional<Team> optionalTeam = teamRepo.findById(id);
        if(optionalTeam.isPresent()) {
            return optionalTeam.get();
        }
        else {
            return null;
        }
    }

    public Team createTeam(Team p) {
        return teamRepo.save(p);
    }
    public Team updateTeam(Team p) {
        return teamRepo.save(p);
    }
    public void deleteTeam(Long id) {
        teamRepo.deleteById(id);
    }
}
