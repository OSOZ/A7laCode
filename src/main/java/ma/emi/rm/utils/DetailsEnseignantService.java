package ma.emi.rm.utils;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ma.emi.rm.business.enseignant.EnseignantService;
import ma.emi.rm.model.entities.Enseignant;

@Service
public class DetailsEnseignantService implements UserDetailsService{
	@Autowired
	EnseignantService enseignantService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		
		Enseignant userInfo = enseignantService.findEnseignantByEmail(email);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
		
		User user = new User(userInfo.getEmail(),userInfo.getPassword(),Arrays.asList(authority));
		
		UserDetails userDetails = (UserDetails)user; 
		return userDetails;
		
	}
}
