package xyz.trixkz.moderation.menu.pagination;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import xyz.trixkz.moderation.menu.Button;
import xyz.trixkz.moderation.menu.Menu;
import xyz.trixkz.moderation.menu.buttons.BackButton;
import xyz.trixkz.moderation.utils.ItemBuilder;
import xyz.trixkz.moderation.utils.Utils;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class ViewAllPagesMenu extends Menu {

	@NonNull @Getter PaginatedMenu menu;

	@Override
	public String getTitle(Player player) {
		return Utils.translate("&eSwitch to page...");
	}

	@Override
	public Map<Integer, Button> getButtons(Player player) {
		HashMap<Integer, Button> buttons = new HashMap<>();

		buttons.put(0, new BackButton(menu));

		int index = 10;
		for (int i = 1; i <= menu.getPages(player); i++) {
			buttons.put(index++, new JumpToPageButton(i, menu, menu.getPage() == i));

			if ((index - 8) % 9 == 0) {
				index += 2;
			}
		}

		fillEmptySlots(buttons, new ItemBuilder(Material.STAINED_GLASS_PANE).durability(7).name(" ").build());

		return buttons;
	}

	@Override
	public boolean isAutoUpdate() {
		return true;
	}

	@Override
	public int getSize() {
		return 3 * 9;
	}
}
