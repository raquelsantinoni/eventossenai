package com.eventos.resources;


import com.eventos.dtos.UsuarioDTO;
import com.eventos.models.Usuario;
import com.eventos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("{id}")
    public  ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuarioService.converterUsuarioParaUsuarioDTO(usuario));
    }
    @GetMapping("/buscar")
    public ResponseEntity<UsuarioDTO>buscarUsuarioPorEmail(@RequestParam String email){
        UsuarioDTO usuario = usuarioService.buscarUsuarioPorEmail(email);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDTO>criarUsuario(@RequestBody UsuarioDTO usuarioDTO ){
        UsuarioDTO dto = usuarioService.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok(dto);


    }
}
