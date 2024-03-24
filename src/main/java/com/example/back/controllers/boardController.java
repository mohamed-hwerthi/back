package com.example.back.controllers;


import com.example.back.jiraResponseDto.boards.*;
import com.example.back.serviceImp.BoardServiceImp;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class boardController {
    private final Logger log = LoggerFactory.getLogger(boardController.class) ;
    private final BoardServiceImp boardService ;

    @GetMapping("/boardRoles/{projectId}")
    public Flux<ProjectRolesResponse> getRolesOfProjet(@RequestHeader("cloudId") String cloudId, @RequestHeader("token") String token, @PathVariable int projectId) {
        return boardService.getRolesOfProjet(cloudId, token, projectId);
    }

    @GetMapping("/getAllBoards")
    public Flux<AllBoardResponseJira>getAllBoard(@RequestHeader("cloudId")String clouudId , @RequestHeader("token")String token ) {
        return this.boardService.getAllBoard(clouudId , token) ;

    }
    @GetMapping("/getBoardWithId/{boardId}")
    public Flux<JiraBoardResponse>getBoardWtihId(@RequestHeader("cloudId")String cloudId , @RequestHeader("token")String token , @PathVariable  int boardId) {
        return boardService.getBoardWtihId(cloudId, token, boardId);
    }


    @GetMapping("/getBoardConfiguration/{boardId}")
    public Flux<BoardConfig> getBoardConfiguration(@RequestHeader("cloudId") String cloudId, @RequestHeader("token") String token, @PathVariable() int boardId) {
        return boardService.getBoardConfiguration(cloudId, token, boardId);
    }
    @GetMapping("/getAllVersionsOfABoard/{boardId}")

    public Flux<VersionResponse> getAllVersionOfABoard(@RequestHeader("cloudId") String cloudId, @RequestHeader("token") String token, @PathVariable() int boardId) {
        return boardService.getAllVersionOfABoard(cloudId, token, boardId);
    }
}
