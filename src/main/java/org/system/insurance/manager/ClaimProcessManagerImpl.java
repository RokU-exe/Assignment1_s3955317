/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.manager;

import java.util.stream.Collectors;
import org.system.insurance.model.Claim;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the ClaimProcessManager interface.
 */

public class ClaimProcessManagerImpl implements ClaimProcessManager {
    private List<Claim> claims = new ArrayList<>();

    @Override
    public void addClaim(Claim claim) {
        claims.add(claim);
    }

    @Override
    public void updateClaim(String claimId, Claim updatedClaim) {
        claims = claims.stream().map(claim -> claim.getId().equals(claimId) ? updatedClaim : claim).collect(Collectors.toList());
    }

    @Override
    public boolean deleteClaim(String claimId) {
        return claims.removeIf(claim -> claim.getId().equals(claimId));
    }

    @Override
    public Claim getOne(String claimId) {
        return claims.stream().filter(claim -> claim.getId().equals(claimId)).findFirst().orElse(null);
    }

    @Override
    public List<Claim> getAll() {
        return new ArrayList<>(claims);
    }
}
