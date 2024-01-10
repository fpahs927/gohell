package kr.neverland.project_24001.twom.control.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;

@Getter
public class GenericNeverlandResponseDTO {
    private Header header=new Header();
    private Result result=null;

    @JsonIgnore
    public static GenericNeverlandResponseDTO Unimplemented = new GenericNeverlandResponseDTO(false,true,"unimplemented");
    @JsonIgnore
    public static GenericNeverlandResponseDTO Success = new GenericNeverlandResponseDTO(true,true,"normal");

    private GenericNeverlandResponseDTO(boolean isSuccess, boolean isEmpty, String message) {
        if(isSuccess){
            header.type="success";
        }
        if(isEmpty){
            result=new GenericNeverlandEmptyResponseDTO();
        }
        header.message=message;
    }

    public static GenericNeverlandResponseDTO test(String message) {
        return new GenericNeverlandResponseDTO(false,true,"unimplemented : "+message);
    }
    public static GenericNeverlandResponseDTO test(String message, Object... tag) {
        GenericNeverlandResponseDTO dto= new GenericNeverlandResponseDTO(false,false,"unimplemented : "+message);
        GenericNeverlandTestResponseDTO _result=new GenericNeverlandTestResponseDTO();
        _result.setRequest(tag);
        dto.result=_result;
        return dto;

    }

    @Getter
    static public class Header{
        private String type = "fail";
        private String message="empty";
    }

    static abstract public class Result {
        @JsonIgnore
        private GenericNeverlandResponseDTO responseDto = null;

        protected void SetParent(GenericNeverlandResponseDTO responseDto) {
            this.responseDto = responseDto;
        }
        public GenericNeverlandResponseDTO toResponseDTO(){
            return responseDto;
        }
        public static <T extends Result> T create(Class<T> clazz, boolean isSuccess, String message) {
            try {
                T currentInstance = (T) (clazz
                        .getDeclaredConstructor().newInstance());
                GenericNeverlandResponseDTO responseDto = new GenericNeverlandResponseDTO(isSuccess,false,message);
                currentInstance.SetParent(responseDto);
                responseDto.result = currentInstance;
                return currentInstance;
            } catch (InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            } catch (IllegalAccessException e) {
            }
            return null;

        }
    }

}
