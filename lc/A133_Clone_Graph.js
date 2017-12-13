/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */

/**
 * Definition for undirected graph.
 * function UndirectedGraphNode(label) {
 *     this.label = label;
 *     this.neighbors = [];   // Array of UndirectedGraphNode
 * }
 */
const UGN = require('./datastructure').UndirectedGraphNode;

/**
 * @param {UndirectedGraphNode} graph
 * @return {UndirectedGraphNode}
 */
const cloneGraph = (graph) => {
    const map = new Map();
    const dfCopy = (gn) => {
        if (!gn) return null;
        if (map.has(gn.label)) {
            return map.get(gn.label);
        }

        const clone = new UGN(gn.label);
        map.set(gn.label, clone);
        for (let neighbor of gn.neighbors) {
            clone.neighbors.push(dfCopy(neighbor));
        }
        return clone;
    }
    return dfCopy(graph);
}