package kr.neverland.project_24001.twom.service.out;

import kr.neverland.project_24001.twom.control.dto.response.obj.GameInfoDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.GameInfoListDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyGameDataInfoSelectedGameAllotDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameInfoService {
    public void getGameInfoList(ArrayList<GameInfoDTO> gameInfoList) {
        if (result == null) {
            return;
        }
        gameInfoList.addAll(result.getData());
    }

    private final WebClient webClient;
    private GameInfoListDTO result=null;

    private final String gameInfoUrl="http://192.168.0.22:27128/apis.divine/sport.btm.779201";
    @Autowired
    public GameInfoService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(gameInfoUrl).build();
    }


    @Scheduled(initialDelay = 3000,fixedRate = 90000)
    public void refreshGameInfoList(){
        GameInfoListDTO _prevResult=this.result;
        this.result=getInformationAll("/request.data.all");
        if(result!=null)
            System.out.println("refreshGameInfoList-->" + result);
        if(_prevResult==null)
            return;
        List<GameInfoDTO> _data=_prevResult.getData();
        if(_data==null)
            return;
        _data.clear();
    }
    public GameInfoListDTO getInformationAll(String requestURL) {
        return getInformation(GameInfoListDTO.class,requestURL);
    }

    public GameInfoDTO getInformationByAllotID(String requestURL) {
        return getInformation(GameInfoDTO.class,requestURL);
    }

    private<T> T getInformation(Class<T> clazz, String requestURL){
        try {
            return webClient.get()
                    .uri(requestURL)
                    .retrieve()
                    .bodyToMono(clazz)
                    .block();
        }catch (Exception ex){
            //ex.printStackTrace();
        }
        return null;
    }
    public void setGameInfoByAllotId(List<MyGameDataInfoSelectedGameAllotDTO> dto) {

        GameInfoDTO current;
        for (MyGameDataInfoSelectedGameAllotDTO d:dto){
            current=_getInformationByAllotID(d.getAllotid());
            if(current==null){
                d.setHomeTeam("-알수없음-");
                d.setAwayTeam("-알수없음-");
                d.setLeagueName("-알수없음-");
                d.setRate(-1F);
                continue;
            }
            d.setHomeTeam(current.getHomeTeam());
            d.setAwayTeam(current.getAwayTeam());
            d.setLeagueName(current.getLeagueName());
            //이것도 구현해야됨
            // d.setRate();
        }
    }

    private GameInfoDTO _getInformationByAllotID(String allotid) {
        GameInfoDTO current=getInformationByAllotIdFrom(result,allotid);
        if(current==null){
            current= getInformationByAllotID("/request.data.by.allotid?allotid='"+allotid+"'");
        }
        return current;
    }

    private GameInfoDTO getInformationByAllotIdFrom(GameInfoListDTO result, String allotid) {
        for (GameInfoDTO infoDto:result.getData()){
            if(infoDto.contains(allotid)){
                return infoDto;
            }
        }
        return null;
    }
}
