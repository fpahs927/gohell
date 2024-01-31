package kr.neverland.project_24001.twom.service.common;

import kr.neverland.project_24001.twom.control.dto.request.StoreInfoAddMyRequestDTO;
import kr.neverland.project_24001.twom.data.entity.MyStore;
import kr.neverland.project_24001.twom.data.entity.Store;
import kr.neverland.project_24001.twom.data.repository.MyStoreRepository;
import kr.neverland.project_24001.twom.data.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreInfoService {
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private MyStoreRepository myStoreRepository;
    public void saveStore(StoreInfoAddMyRequestDTO storeDTO) {
        MyStore mystore = new MyStore();
    //    mystore.setStore(storeDTO.getStoreCode());

        storeRepository.save(mystore);
        //myStoreRepository.save(storeDTO);
    }
}
