package com.mju.insurance.service.employee.uwManagement;

import org.springframework.stereotype.Service;

@Service
public class SUwManagementImpl implements SUwManagement {
//    private final UWRepository uwRepository = UWRepository.getInstance();
//
//    @Override
//    public ArrayList<UW> getAll() {
//        return uwRepository.getAll();
//    }
//
//    @Override
//    public ArrayList<UW> getAllUnderAudit() {
//        ArrayList<UW> uws = this.getAll();
//        return new ArrayList<UW>(uws.parallelStream().filter(uw -> uw.getUwState().equals(UWState.UNDER_AUDIT))
//        		.collect(Collectors.toList()));
//    }
//
//    @Override
//    public UW getById(String id) {
//        return uwRepository.get(id);
//    }
//
//    @Override
//    public boolean acceptUw(UW uw) {
//        if(uw.getUwState().equals(UWState.ACCEPTED)) return false;
//        uw.setUwState(UWState.ACCEPTED);
//        return uwRepository.update(uw);
//    }
//
//    @Override
//    public boolean rejectUw(UW uw) {
//        if(uw.getUwState().equals(UWState.REJECTED)) return false;
//        uw.setUwState(UWState.REJECTED);
//        return uwRepository.update(uw);
//    }
//
//    @Override
//    public boolean requestAdditionalDocument(String uwId, String documentName) {
//        UW uw = this.getById(uwId);
//        UWDocument uwDocument = new UWDocument();
//        uwDocument.setName(documentName);
//        uwDocument.setUwId(uwId);
//        uwDocument.setPath("/documents/" + documentName);
//        uwDocument.setUwDocumentState(UWDocumentState.REQUESTED);
//        uw.addDocument(uwDocument);
//        return uwRepository.update(uw);
//    }
//
//    @Override
//    public boolean updateUw(UW uw) {
//        return uwRepository.update(uw);
//    }
//
//    @Override
//    public boolean updateUwDocument(UWDocument uwDocument) {
//        return uwRepository.updateUwDocument(uwDocument);
//    }
//
//    @Override
//    public boolean addUw(UW uw) {
//        return uwRepository.add(uw);
//    }
}
