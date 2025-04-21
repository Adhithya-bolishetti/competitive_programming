class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int current = asteroids[i];
            boolean destroyed = false;

            while (!st.isEmpty() && current < 0 && st.peek() > 0) {
                if (st.peek() < -current) {
                    st.pop(); // Top is smaller, so destroyed
                } else if (st.peek() == -current) {
                    st.pop(); // Both destroy each other
                    destroyed = true;
                    break;
                } else {
                    // Incoming asteroid is smaller, it's destroyed
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(current);
            }
        }

        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return result;
    }
}
