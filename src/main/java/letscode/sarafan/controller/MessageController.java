//package letscode.sarafan.controller;
//
//
//import letscode.sarafan.domain.Message;
//import letscode.sarafan.repo.MessageRepo;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("message")
//public class MessageController {
//    private final MessageRepo messageRepo;
//
//    @Autowired
//    public MessageController(MessageRepo messageRepo) {
//        this.messageRepo = messageRepo;
//    }
//
//
//    @GetMapping
//    public List<Message> list() {
//        return messageRepo.findForUser();
//    }
//
//
//    @GetMapping("{id}")
//    public Message getOne(@PathVariable Message message) {
//        return message;
//    }
//
//
//
//
//    @PostMapping
//    public Message create(@RequestBody Message message ){
//        return messageRepo.save(message);
//    }
//
//    @PutMapping("{id}")
//    public Message update(@PathVariable("id") Message oldMessage,
//                          @RequestBody Message message
//    ){
//        System.out.println(oldMessage);
//        System.out.println(message);
//        BeanUtils.copyProperties(message, oldMessage, "id");
//
//        return messageRepo.save(oldMessage);
//    }
//
//    @DeleteMapping("{id}")
//    public void delete(@PathVariable ("id") Message message){
//         messageRepo.delete(message);
//    }
//
//}


package letscode.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import letscode.sarafan.domain.Message;

import letscode.sarafan.domain.User;
import letscode.sarafan.domain.Views;
import letscode.sarafan.dto.MessagePageDto;
import letscode.sarafan.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("message")
public class MessageController {
    public static final int  MESSAGE_PER_PAGE = 3;
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping
    @JsonView(Views.FullMessage.class)
    public MessagePageDto list(
            @AuthenticationPrincipal User user,
            @PageableDefault(size = MESSAGE_PER_PAGE, sort = {"id"}, direction = Sort.Direction.DESC)
            Pageable pageable
    ) {
        return messageService.findForUser(pageable, user);
    }

//"Could not write JSON: failed to lazily initialize a collection of role:
@JsonView(Views.FullMessage.class)
@PostMapping
    public Message create(
            @RequestBody Message message,
            @AuthenticationPrincipal User user) throws IOException {
        return messageService.create(message, user);
    }

    @PutMapping("{id}")
    @JsonView(Views.FullMessage.class)
    public Message update(
            @PathVariable("id") Message messageFromDb,
            @RequestBody Message message
    ) throws IOException {
       return messageService.update(messageFromDb, message);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
        messageService.delete(message);
    }
}