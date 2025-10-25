package in.laksys;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reguser")
public class ReguserController {
	@Autowired
	private ReguserRepo repo;
	
	@GetMapping("/{email}")
	public Reguser getUser(@PathVariable String email) {
		return repo.findById(email).orElseThrow(()-> new NoSuchElementException("No user found for that id "+email));
	}
	@PostMapping
	public Reguser addUser(@RequestBody Reguser reguser) {
		String pword = reguser.getPword();
		reguser.setPword(generateMD5(pword));
		return repo.save(reguser);
	}
	@PostMapping("/auth")
	public ResponseEntity<Map<String, String>> authenticate(@RequestBody Reguser reguser){
		Map<String, String> map = new HashMap<>();
		
		Optional<Reguser> opt = repo.findById(reguser.getEmail());
		if (opt.isEmpty()) {
			map.put("success", "false");		
			map.put("message", "No user found");			
		} else {
			Reguser user = opt.get();
			if ( user.getPword().equals(generateMD5(reguser.getPword()))) {
				map.put("success", "true");		
				map.put("message", "Authenticated");
			} else {
				map.put("success", "false");		
				map.put("message", "Password mis match");
			}
		}		
		return ResponseEntity.ok(map);
	}
	public static String generateMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
