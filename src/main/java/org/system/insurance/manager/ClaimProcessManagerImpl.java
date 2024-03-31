/**
 * @author <Le Xuan Loc - s3955317>
 */

package org.system.insurance.manager;

import org.system.insurance.model.Claim;
import java.util.ArrayList;
import java.util.List;

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
        for (int i = 0; i < claims.size(); i++) {
            if (claims.get(i).getId().equals(claimId)) {
                claims.set(i, updatedClaim);
                return;
            }
        }
        System.out.println(STR."Claim with ID \{claimId} not found.");
    }

    @Override
    public boolean deleteClaim(String claimId) {
        for (int i = 0; i < claims.size(); i++) {
            if (claims.get(i).getId().equals(claimId)) {
                claims.remove(i);
                return true;
            }
        }
        return false;
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
