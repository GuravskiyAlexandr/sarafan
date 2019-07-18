package letscode.sarafan.dto;


//import com.fasterxml.jackson.annotation.JsonRawValue;
//import com.fasterxml.jackson.annotation.JsonView;
//import letscode.sarafan.domain.Views;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//@Data
////@AllArgsConstructor
//@JsonView(Views.Id.class)
//public class WsEventsDto {
//    private ObjectType objectType;
//    private EventType eventType;
////    чтобы в json не встраивалась строка с jsonom
//    @JsonRawValue
//    private String body;
//
//    public WsEventsDto(ObjectType objectType, EventType eventType, String body) {
//        this.objectType = objectType;
//        this.eventType = eventType;
//        this.body = body;
//    }
//}

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.domain.Views;
import lombok.AllArgsConstructor;
import lombok.Data;


@JsonView(Views.Id.class)
public class WsEventsDto {
    private ObjectType objectType;
    private EventType eventType;
    @JsonRawValue
    private String body;

    public WsEventsDto(ObjectType objectType, EventType eventType, String body) {
        this.objectType = objectType;
        this.eventType = eventType;
        this.body = body;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
