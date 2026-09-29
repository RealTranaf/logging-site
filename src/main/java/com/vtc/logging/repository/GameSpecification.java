package com.vtc.logging.repository;

import com.vtc.logging.model.Game;
import com.vtc.logging.model.Platform;
import com.vtc.logging.model.PubStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class GameSpecification {

    public static Specification<Game> hasPlatform(Platform platform) {
        return (root, query, cb) -> {
            if (platform == null) {
                return null;
            }
            return cb.equal(root.get("platform"), platform);
        };
    }

    public static Specification<Game> hasStatus(PubStatus status) {
        return (root, query, cb) -> {
            if (status == null) {
                return null;
            }
            return cb.equal(root.get("status"), status);
        };
    }
}
