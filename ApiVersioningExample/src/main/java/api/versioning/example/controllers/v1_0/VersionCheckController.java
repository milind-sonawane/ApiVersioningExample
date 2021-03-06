package api.versioning.example.controllers.v1_0;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindstix.web.api.version.management.annotations.ApiVersion;

@RestController("VersionCheckController_v1_0")
@ApiVersion("1.0")
public class VersionCheckController {

    @RequestMapping(path = "/")
    public ResponseEntity<String> checkControllerVersion() {
        return new ResponseEntity<>("Controller Version 1.0", HttpStatus.OK);

    }
 }
