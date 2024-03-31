/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.manager;

import org.system.insurance.model.Claim;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the ClaimProcessManager interface.
 */
public class ClaimProcessManagerImpl implements ClaimProcessManager {
    private List<Claim> claims; // The list to store claims

    public ClaimProcessManagerImpl() {
        this.claims = new ArrayList<>();
    }

    @Override
    public void addClaim(Claim claim) {
        claims.add(claim);
    }

    @Override
    public void updateClaim(String claimId, Claim updatedClaim) {
        Claim claim = getOne(claimId);
        if (claim != null) {
            int index = claims.indexOf(claim);
            claims.set(index, updatedClaim);
        }
    }

    @Override
    public boolean deleteClaim(String claimId) {
        return claims.removeIf(claim -> claim.getId().equals(claimId));
    }

    @Override
    public Claim getOne(String claimId) {
        Optional<Claim> claim = claims.stream()
                .filter(c -> c.getId().equals(claimId))
                .findFirst();
        return claim.orElse(null);
    }

    @Override
    public List<Claim> getAll() {
        return new ArrayList<>(claims);
    }
}
