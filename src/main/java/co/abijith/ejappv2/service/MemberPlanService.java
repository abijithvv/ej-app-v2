package co.abijith.ejappv2.service;

import co.abijith.ejappv2.entity.MemberPlans;
import co.abijith.ejappv2.repo.MemberPlansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberPlanService {

    @Autowired
    MemberPlansRepo memberPlansRepo;

    //save new member plan
    public void saveNewMemberPlan(MemberPlans memberPlans) {
        memberPlansRepo.save(memberPlans);
    }

    public List<MemberPlans> fetchAllMemberPlans(){
        return memberPlansRepo.findAll();
    }


}
