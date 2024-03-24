package com.example.back.serviceDec;

import com.example.back.jiraResponseDto.boards.*;
import reactor.core.publisher.Flux;

public interface BoardServiceDec {

    Flux<AllBoardResponseJira>getAllBoard(String cloudId , String token) ;
    Flux<JiraBoardResponse>getBoardWtihId(String cloudId , String token , int BoardId) ;
    Flux<BoardConfig>getBoardConfiguration(String cloudId , String token , int boardId) ;

   // Returns all versions from a board  :
    Flux<VersionResponse>getAllVersionOfABoard(String cloudId , String token , int boardId) ;
    //getting roles of one board  :
    Flux<ProjectRolesResponse> getRolesOfProjet(String cloudId , String token  , int projectId) ;



}
