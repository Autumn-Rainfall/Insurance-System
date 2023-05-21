package com.mju.insurance.service.employee.insuranceManagement;

import org.springframework.stereotype.Service;

@Service
public class SInsuranceManagementImpl implements SInsuranceManagement{
//    private final InsuranceRepository insuranceRepository = InsuranceRepository.getInstance();
//
//    @Override
//    public ArrayList<Insurance> getAll() {
//        return insuranceRepository.getAll();
//    }
//
//    @Override
//    public Insurance getById(String id) {
//        return insuranceRepository.get(id);
//    }
//
//    @Override
//    public Insurance getByName(String name) {
//        return insuranceRepository.getByName(name);
//    }
//
//    @Override
//    public boolean addInsurance(Insurance insurance) {
//        return insuranceRepository.add(insurance);
//    }
//
//    @Override
//    public boolean deleteInsurance(String id) {
//        return insuranceRepository.delete(id);
//    }
//
//    @Override
//    public boolean updateInsurance(Insurance insurance) {
//        return insuranceRepository.update(insurance);
//    }
//
//    @Override
//    public boolean updateClause(Clause clause) {
//        return insuranceRepository.updateClause(clause);
//    }
//
//    @Override
//    public boolean requestAuditForSale(Insurance insurance) {
//        InsuranceState insuranceState = insurance.getInsuranceState();
//        if(!(insuranceState.equals(InsuranceState.BEFORE_AUDIT) || insuranceState.equals(InsuranceState.REJECTED))) return false;
//        insurance.setInsuranceState(InsuranceState.UNDER_AUDIT);
//        return insuranceRepository.update(insurance);
//    }
//
//    @Override
//    public Clause getClauseById(String clauseId) {
//        return insuranceRepository.getClause(clauseId);
//    }
}
